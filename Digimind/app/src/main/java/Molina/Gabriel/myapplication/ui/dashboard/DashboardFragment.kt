package Molina.Gabriel.myapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import Molina.Gabriel.myapplication.R
import Molina.Gabriel.myapplication.ui.home.agenda
import Molina.Gabriel.myapplication.ui.home.HomeFragment
import android.app.TimePickerDialog
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import java.text.SimpleDateFormat
import java.util.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        root.btn_time.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY,hour)
                cal.set(Calendar.HOUR_OF_DAY,minute)

                btn_time.text = SimpleDateFormat("HH:mm").format(cal.time)

            }

            TimePickerDialog(root.context, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()

        }

        root.btn_done.setOnClickListener {
            var title = et_task.text.toString()
            var time = btn_time.text.toString()

            var days = ArrayList<String>()

            if (monday.isChecked)
                days.add("Monday")
            if (tuesday.isChecked)
                days.add("Tuesday")
            if (wednesday.isChecked)
                days.add("Wednesday")
            if (thurday.isChecked)
                days.add("Thursday")
            if (friday.isChecked)
                days.add("Friday")
            if (saturday.isChecked)
                days.add("Saturday")
            if (sunday.isChecked)
                days.add("Sunday")

            var task = agenda(title, days, time)

            HomeFragment.agenda.add(task)
            //HomeFragment.first = true

            Toast.makeText(root.context, "New Task added", Toast.LENGTH_SHORT).show()


        }

        return root


    }
}