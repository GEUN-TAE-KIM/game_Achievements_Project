package org.cream.geuntae_hobby.ui.setting

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.cream.geuntae_hobby.R
import org.cream.geuntae_hobby.databinding.FragmentSettingBinding
import org.cream.geuntae_hobby.ui.MainActivity

class SettingFragment : Fragment() {

    private lateinit var binding: FragmentSettingBinding
    lateinit var mainActivity: MainActivity
    private val viewModel: SettingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        initClickEvent()

        mainActivity = context as MainActivity

    }

    // 함수로 만들어서 클릭 이벤트 처리 보기 쉽고 간결 한듯
    private fun initClickEvent() {
        with(binding) {
            appVersion.setOnClickListener { showDialogVersion() }
            ibMoreAppVersion.setOnClickListener { showDialogVersion() }

            contactEmail.setOnClickListener { sendEmail() }
            ibMoreEmail.setOnClickListener { sendEmail() }

            appLicense.setOnClickListener { navigateToWebSite("https://github.com/GEUN-TAE-KIM/GeunTae_hobby") }
            ibMoreOpenAppLicense.setOnClickListener { navigateToWebSite("https://github.com/GEUN-TAE-KIM/GeunTae_hobby") }
        }
    }

    private fun sendEmail() {
        val emailAddress = "rmsxo0418@gmail.com"

        val intent = Intent(Intent.ACTION_SENDTO)
            .apply {
                type = "text/plain"
                data = Uri.parse("mailto:") // 이메일 앱에서만 인텐트 처리되도록 설정
                putExtra(Intent.EXTRA_EMAIL, arrayOf<String>(emailAddress))
            }

        startActivity(intent)
    }


    private fun getVersion(context: Context): String {
        var versionName = ""
        try {
            val pInfo: PackageInfo =
                context.packageManager.getPackageInfo(context.packageName, 0)
            versionName = "App Version : " + pInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return versionName
    }

    private fun showDialogVersion() {
        val builder = AlertDialog.Builder(mainActivity)
        builder
            .setTitle("Version")
            .setMessage(getVersion(mainActivity))
            .setIcon(null)
            .setPositiveButton("Check") { dialog, which ->
                R.string.dialog_ok_button
            }
            .create()
            .show()
    }

    private fun navigateToWebSite(address: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(address))
        startActivity(intent)
    }

}