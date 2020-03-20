package Molina.Gabriel.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import Molina.Gabriel.myapplication.R
import android.content.Context
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.board.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    var adapter: agendaAdapter? = null
    private lateinit var homeViewModel: HomeViewModel


    companion object{
        var agenda = ArrayList<agenda>()
        var first = true
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)


        if (first){
            cargarAgenda()
            first = false
        }


        adapter = agendaAdapter(root.context, agenda)

        root.gridview.adapter = adapter

        return root
    }

    fun cargarAgenda(){
        //Cargar
       agenda.add(
           agenda(
               "Practica",
               arrayListOf("Everyday"),
               "17:30"
           )
       )
       agenda.add(
           agenda(
               "Practica",
               arrayListOf("Everyday"),
               "17:30"
           )
       )
       agenda.add(
           agenda(
               "Practica",
               arrayListOf("Everyday"),
               "17:30"
           )
       )
       agenda.add(
           agenda(
               "Practica",
               arrayListOf("Everyday"),
               "17:30"
           )
       )
       agenda.add(
           agenda(
               "Practica",
               arrayListOf("Everyday"),
               "17:30"
           )
       )
       agenda.add(
           agenda(
               "Practica",
               arrayListOf("Everyday"),
               "17:30"
           )
       )
       agenda.add(
           agenda(
               "Practica",
               arrayListOf("Everyday"),
               "17:30"
           )
       )
       agenda.add(
           agenda(
               "Practica",
               arrayListOf("Everyday"),
               "17:30"
           )
       )
       agenda.add(
           agenda(
               "Practica",
               arrayListOf("Everyday"),
               "17:30"
           )
       )

    }

    class agendaAdapter: BaseAdapter {
        var agenda = ArrayList<agenda>()
        var context: Context? = null

        constructor(context: Context, agenda: ArrayList<agenda>){
            this.context = context
            this.agenda = agenda
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var agenda = agenda[p0]
            var inflator = LayoutInflater.from(context)
            var vista = inflator.inflate(R.layout.board, null)
            vista.tv_actividad.setText(agenda.actividad)
            vista.tv_days.setText(agenda.dias.toString())
            vista.tv_hours.setText(agenda.hora)

            return vista

        }

        override fun getItem(p0: Int): Any {
            return agenda[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return agenda.size
        }

    }

}