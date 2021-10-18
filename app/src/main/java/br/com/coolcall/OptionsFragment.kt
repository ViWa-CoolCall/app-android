package br.com.coolcall

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import br.com.coolcall.databinding.FragmentOptionsBinding

class OptionsFragment : Fragment() {

    private lateinit var binding: FragmentOptionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_options, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            arrayAdapter(it, binding.spinnerMesInicial, R.array.options_meses)
            arrayAdapter(it, binding.spinnerMesFinal, R.array.options_meses)
            arrayAdapter(it, binding.spinnerQuebra, R.array.options_quebras)
            arrayAdapter(it, binding.spinnerReceita, R.array.options_receitas)
        }

        binding.btnPesquisar.setOnClickListener {
            val action = OptionsFragmentDirections.actionOptionsFragmentToDownloadFragment()
            view.findNavController().navigate(action)
        }
    }

    private fun arrayAdapter(context: Context, spinner: Spinner, options: Int) {
        ArrayAdapter.createFromResource(
            context,
            options,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }
}