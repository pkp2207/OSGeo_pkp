package com.example.osgeo_pkp


import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.ActivityCompat
import android.widget.Toast
import java.util.jar.Manifest

class SplashActivity : AppCompatActivity() {

    var permissionsString = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if(hasPermissions(this@SplashActivity, *permissionsString )){
            //we have to ask for permissions
            ActivityCompat.requestPermissions(this@SplashActivity, permissionsString, 131)
        }else{
            Handler().postDelayed({
                val startAct = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(startAct)
                //to kill the SPlashActivity
                this.finish()
            }, 3000/*3000 millisecs is the time after which the SplashActivity is killed*/)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            131->{
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Handler().postDelayed({
                        val startAct = Intent(this@SplashActivity, MainActivity::class.java)
                        startActivity(startAct)
                        //to kill the SPlashActivity
                        this.finish()
                    }, 1000/*1000 millisecs is the time after which the SplashActivity is killed*/)
                }
                else{
                    Toast.makeText(this@SplashActivity, "Please grant all the permissions to continue", Toast.LENGTH_SHORT)
                    this.finish()
                }
                return
            }
            else->{
                Toast.makeText(this@SplashActivity, "Something went wrong", Toast.LENGTH_SHORT).show()
                this.finish()
                return
            }
        }

    }
    fun hasPermissions(context: Context, vararg permissions: String):Boolean{
        var hasAllPermissions = true
        for(permission in permissions)
        {
            val res = context.checkCallingOrSelfPermission(permission)
            if(res!=PackageManager.PERMISSION_GRANTED)//which means that permission has not been granted
            {
                hasAllPermissions = false

            }//if ends here
        }//for ends here
        return hasAllPermissions
    }//vararg converts the arrayOf array into a simple array
}
