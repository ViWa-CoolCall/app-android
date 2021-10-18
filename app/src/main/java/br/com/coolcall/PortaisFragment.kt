package br.com.coolcall

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import br.com.coolcall.databinding.FragmentPortaisBinding

class PortaisFragment : Fragment() {

    private lateinit var binding: FragmentPortaisBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_portais, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnReceitas.setOnClickListener {
            val action = PortaisFragmentDirections.actionPortaisFragmentToOptionsFragment()
            view.findNavController().navigate(action)
        }
    }
}