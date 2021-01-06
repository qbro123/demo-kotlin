package vnext.tuantq.examplekotlin.utils

import android.content.Context
import android.widget.Toast

object CustomToast {

    //using static in kotlin
    @JvmStatic
    //custom function in object kotlin
    fun showMessage(context: Context, message: String) {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

}