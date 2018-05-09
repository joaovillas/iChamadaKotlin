import android.view.ViewGroup
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.BaseAdapter
import android.widget.ImageView
import com.xitados.ichamada.Alunos
import kotlinx.android.synthetic.main.activity_turmas.view.*
import java.util.zip.Inflater

private class RecipeAdapter (plistadealunos:MutableList<Alunos>, context:Context): BaseAdapter(){

    private val mContext: Context

    init{
        this.mContext = context
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(mContext)
        
    }

    override fun getItem(p0: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(p0: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

}