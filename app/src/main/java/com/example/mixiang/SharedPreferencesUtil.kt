import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesUtil {
    private const val PREFS_NAME = "UserPrefs"

    fun saveUserCredentials(context: Context, username: String, password: String) {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("username", username)
        editor.putString("password", password)
        editor.apply()
    }

    fun getUsername(context: Context): String {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString("username", "") ?: ""
    }

    fun getPassword(context: Context): String {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString("password", "") ?: ""
    }
}
