package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

public class ThirdActivity extends Activity {
    private final int PHONE_CALL_CODE = 100;
    //declaro
    private EditText editTextPhone;
    private EditText editTextWeb;
    private ImageButton imgBtnWeb;
    private ImageButton imgBtnCamera;
    private ImageButton imgBtnPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //las obtengo desde el view
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextWeb = (EditText) findViewById(R.id.editTextWeb);
        imgBtnWeb = (ImageButton) findViewById(R.id.imgBtnWeb);
        imgBtnCamera = (ImageButton) findViewById(R.id.imgBtnCamera);
        imgBtnPhone = (ImageButton) findViewById(R.id.imgBtnPhone);
        //Que quiero hacer!
        /*
         *  quermos acción sobre ese botón
         *  cuando se haga click en el telefono
         *  queremos una accion
         *
         */
        imgBtnPhone.setOnClickListener(new View.OnClickListener() {
            /*
            cuando se sobre escribe el onClick, el view que le llega se corresponde
            con el método que se hace clic, el de boton en este caso
            viene comoun view y se castea al botón en caso de ser necesario.
             */
            @Override
            public void onClick(View v) {
                String phoneNumber = editTextPhone.getText().toString();
                if (phoneNumber != null && !phoneNumber.isEmpty()) {
                    //comprobar versión actual de Android que ejecutamos en este momento.
                    int actualVersion = Build.VERSION.SDK_INT;
                    int minimalVersionSupported = Build.VERSION_CODES.M;
                    // verifica que estemos en una versión igual o mayor que la más baja
                    // de las que piden permisos al momento de ejecutar.
                    //chequea los permisos mas bajos
                    if (actualVersion >= minimalVersionSupported) {
                        //COMPROBAR SI YA ACEPTO PERMISOS, NUNCA HACEPTO
                        if (CheckPermission(Manifest.permission.CALL_PHONE)){
                            //ha aceptado
                            Intent i = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+phoneNumber));
                            if(ActivityCompat.checkSelfPermission(ThirdActivity.this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {return;}
                            startActivity((i));
                        }
                        else {
                            //no ha denegado
                          if   (!shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)){
                              //no se ha preguntado aun
                              requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, PHONE_CALL_CODE);
                          }
                          else {
                              // ha denegado permiso
                              Toast.makeText(ThirdActivity.this, "Please enable the permissions for this app", Toast.LENGTH_SHORT).show();
                              Intent i = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                              i.addCategory(Intent.CATEGORY_DEFAULT);
                              //obtener nombre de nuestro paquete
                              i.setData(Uri.parse("package:"+getPackageName()));
                              //determina como se comporta nuestra aplicación en cossas como el para atras y eso.
                              i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                              i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                              i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                              startActivity(i);
                          }
                        }
                    } else {
                        OlderVersions(phoneNumber);
                    }
                }
                else {
                    Toast.makeText(ThirdActivity.this,"El numero no puede ser vacio",Toast.LENGTH_LONG).show();
                }
            }
            private void OlderVersions(String phoneNumber) {
                //Versiones de telefono inferior a V6
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
                //COMNSULTAMOS POR EL PERMISO, definido en el manifest
                if (CheckPermission(Manifest.permission.CALL_PHONE)) {
                    startActivity(intentCall);
                } else {
                    Toast.makeText(ThirdActivity.this, "You declined the access", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //boton para la direccoón web
        //siempre dentro del oncreatew
        imgBtnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editTextWeb.getText().toString();
                if (url!=null && !url.isEmpty()){
                    Intent intentWeb = new Intent();
                    intentWeb.setAction(Intent.ACTION_VIEW);
                    intentWeb.setData(Uri.parse("http://"+url));







                    startActivity(intentWeb);

                }

            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        //int requestCode es el código enviado arriba PHONE_CALL_CODE
        //Estamos en el caso del teléfono
        if (requestCode == PHONE_CALL_CODE) {

        }
        try {
            switch (requestCode) {
                case PHONE_CALL_CODE:
                    //mandamos solo uno
                    String permission = permissions[0];
                    int result = grantResults[0];
                    if (permission.equals(Manifest.permission.CALL_PHONE)) {
                        //comprobar si ha sido aceptado o denegada la petición de permiso.
                        if (result == getPackageManager().PERMISSION_GRANTED) {
                            //Permiso concedido.
                            String phoneNumber = editTextPhone.getText().toString();
                            Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
                            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                return;
                            }
                            startActivity(intentCall);

                        } else {
                            //no concedido permiso.
                            Toast.makeText(ThirdActivity.this, "You declined the acces to the call", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
                default:
                    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        catch (Exception exp){
            Toast.makeText(this,exp.getMessage(),Toast.LENGTH_LONG).show();
        }

    }
    //para compprobar si ha permisos
    //hahy que agregarlo en el manifest. uses-permission como etiqueta

    private boolean CheckPermission(String permission) {
        int result = this.checkCallingOrSelfPermission(permission);
        return result == PackageManager.PERMISSION_GRANTED;
    }

}
