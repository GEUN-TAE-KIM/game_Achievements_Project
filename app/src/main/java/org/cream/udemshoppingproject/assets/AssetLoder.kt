package org.cream.udemshoppingproject.assets

import android.content.Context

//json 파일을 스트링 파일로 처리함으로써 읽어 오기 위한 것
class AssetLoder {

    fun getJsonString(context: Context, fileName: String): String? {

        // Exception을 처리하는 것
        return kotlin.runCatching {
            loadAsset(context, fileName)
        }.getOrNull()
    }

    private fun loadAsset(context: Context, fileName: String): String {
        // assets 파일에 접근을 할려면 context(정보에 접근)를 사용
        // use(확장함수)를 통해
        return context.assets.open(fileName).use { inputStream ->
            //스트림에 실제로 값이 존재 하는지
            val size = inputStream.available()
            // 초기화
            val bytes = ByteArray(size)
            // 바이트에 전달
            inputStream.read(bytes)
            // 문자열로 해서 확인
            String(bytes)

        }

    }

}