package portfolio.shiikharshah.ui.adapters

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import portfolio.shiikharshah.R
import portfolio.shiikharshah.ui.datamodels.DrawerItem

class MenuAdapter(var mcontext: Context, var layoutResID: Int, var drawerItemList: List<DrawerItem>) :
    ArrayAdapter<DrawerItem?>(mcontext, layoutResID, drawerItemList) {
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View { // TODO Auto-generated method stub
        val drawerHolder: DrawerItemHolder
        var view = convertView
        if (view == null) {
            val inflater = (context as Activity).layoutInflater
            drawerHolder = DrawerItemHolder()
            view = inflater.inflate(layoutResID, parent, false)
            drawerHolder.ItemName = view.findViewById(R.id.drawer_itemName)
            view.tag = drawerHolder
        } else {
            drawerHolder = view.tag as DrawerItemHolder
        }
        val dItem = drawerItemList[position]
        drawerHolder.ItemName!!.text = dItem.itemName
        return view!!
    }

    private class DrawerItemHolder {
        var ItemName: TextView? = null
    }

}