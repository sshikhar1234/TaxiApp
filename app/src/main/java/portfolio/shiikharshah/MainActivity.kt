package portfolio.shiikharshah

import android.os.Bundle
import android.view.Menu
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.activity_main.*
import portfolio.shiikharshah.ui.fragments.DrawerFragment

class MainActivity : BaseAppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerFragment: DrawerFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerFragment = supportFragmentManager.findFragmentById(R.id.fragment_navigation_drawer) as DrawerFragment
        drawerFragment.init(R.id.fragment_navigation_drawer, drawer_layout as DrawerLayout)

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

}
