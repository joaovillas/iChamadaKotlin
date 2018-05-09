import android.content.Context
import android.R.*
import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.xitados.ichamada.Alunos
import com.xitados.ichamada.R
import kotlinx.android.synthetic.main.linha_aluno.view.*


class qualquer_coisa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_turmas)
    }

    class RecipeAdapter(private val context: Context,
                        private val dataSource: ArrayList<Alunos>) : BaseAdapter() {


        private val mContext: Context

        init {
            this.mContext = context
        }

        private val layoutinflater = LayoutInflater.from(mContext)
        override fun getCount(): Int {
            return dataSource.size
        }

        //2
        override fun getItem(position: Int): Any {
            return dataSource[position]
        }

        //3
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        //4
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            // Get view for row item
            val rowView = layoutinflater.inflate(R.layout.linha_aluno, parent, false)

            return rowView
        }


    }

}