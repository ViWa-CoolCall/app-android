package br.com.coolcall

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import androidx.databinding.DataBindingUtil
import br.com.coolcall.databinding.FragmentDownloadBinding

class DownloadFragment : Fragment() {

    private lateinit var binding: FragmentDownloadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_download, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDownloadPdf.setOnClickListener {
            downloadFiles("pdf")
        }
        binding.btnDownloadTxt.setOnClickListener {
            downloadFiles("txt")
        }
        binding.btnDownloadCsv.setOnClickListener {
            downloadFiles("csv")
        }
        binding.btnDownloadOdt.setOnClickListener {
            downloadFiles("odt")
        }
        binding.btnDownloadOdf.setOnClickListener {
            downloadFiles("odf")
        }
        binding.btnDownloadOds.setOnClickListener {
            downloadFiles("ods")
        }
    }

    private fun downloadFiles(fileExtension: String) {
        val url = "https://coolcall-api.herokuapp.com/files/relatorio.${fileExtension}"
        val title = URLUtil.guessFileName("Receitas", null, null)

        val request = DownloadManager.Request(Uri.parse(url))
        request.setTitle(title)
        request.setDescription("Downloading File, please wait......")
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title)

        val dm = activity?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        dm.enqueue(request)
    }
}