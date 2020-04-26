package portfolio.shiikharshah.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_drawer.*
import portfolio.shiikharshah.BaseFragment
import portfolio.shiikharshah.R
import portfolio.shiikharshah.ui.adapters.DrawerAdapter
import portfolio.shiikharshah.ui.datamodels.DrawerItem
import java.lang.RuntimeException
import java.util.ArrayList

class DrawerFragment : BaseFragment(){
    private lateinit var adapter: DrawerAdapter

    private var drawerListener: FragmentDrawerListener? = null
    private var mDrawerLayout: DrawerLayout? = null
    private var containerView: View? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            drawerListener = context as FragmentDrawerListener
        }
        catch (e: RuntimeException){
            Log.d("TAG",e.localizedMessage)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //get menu titles
        var titles = activity?.resources?.getStringArray(R.array.nav_drawer_labels)
        //Create arraylist of DrawerItems
        val data = ArrayList<DrawerItem>()

        //Fill in the nav items
        for ( i in titles!!.indices) {
            var navItem = DrawerItem(itemName = titles[i])
            data.add(navItem)
        }

        adapter = DrawerAdapter(data)
        rv_drawer_list.adapter = adapter
        rv_drawer_list.layoutManager = LinearLayoutManager(activity)
        rv_drawer_list.addOnItemTouchListener(RecyclerTouchListener(activity!!.baseContext, rv_drawer_list, object : ClickListener {
            override fun onClick(view: View, position: Int) {
                drawerListener?.onDrawerItemSelected(view, position)
                mDrawerLayout?.closeDrawer(containerView!!)
            }
            override fun onLongClick(view: View?, position: Int) {

            }
        }))
    }
    fun init(fragmentId: Int, drawerLayout: DrawerLayout) {
        containerView = activity?.findViewById(fragmentId)
        mDrawerLayout = drawerLayout
        val drawerToggle = object : ActionBarDrawerToggle(activity, drawerLayout, R.string.drawer_open, R.string.drawer_close) {
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                activity?.invalidateOptionsMenu()
            }
            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                activity?.invalidateOptionsMenu()
            }
        }
        mDrawerLayout?.addDrawerListener(drawerToggle)
        mDrawerLayout?.post { drawerToggle.syncState() }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_drawer, container, false)
    }
    interface FragmentDrawerListener {
        fun onDrawerItemSelected(view: View, position: Int)
    }

    interface ClickListener {
        fun onClick(view: View, position: Int)
        fun onLongClick(view: View?, position: Int)
    }
    internal class RecyclerTouchListener(context: Context, recyclerView: RecyclerView, private val clickListener: ClickListener?) : RecyclerView.OnItemTouchListener {

        private val gestureDetector: GestureDetector

        init {
            gestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(e: MotionEvent): Boolean {
                    return true
                }
                override fun onLongPress(e: MotionEvent) {
                    val child = recyclerView.findChildViewUnder(e.x, e.y)
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child))
                    }
                }
            })
        }

        override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {

            val child = rv.findChildViewUnder(e.x, e.y)
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildAdapterPosition(child))
            }
            return false
        }

        override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}

        override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

        }
    }
}