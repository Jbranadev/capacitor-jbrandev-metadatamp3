package com.jbrandev.capacitor.metadatamp3;

import android.Manifest;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.PermissionState;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.getcapacitor.annotation.PermissionCallback;

@CapacitorPlugin(name = "metadatamp3",
permissions={
        @Permission(
                alias = "storage",
                strings = {
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }
        )
}

)
public class metadatamp3Plugin extends Plugin {

    private metadatamp3 implementation = new metadatamp3();


    @PermissionCallback
    private void storagePermsCallback(PluginCall call) {
        if (getPermissionState("storage") == PermissionState.GRANTED) {
            //Aquí llamo lo necesario
            Log.i("MetaDataMp3", "Valido que la aplicación si tenga permisos de lectura");
            getMetadata(call);
        } else {
            call.reject("Permission is required to take a picture");
        }
    }

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");
        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void getMetadata(PluginCall call){
        if (getPermissionState("storage") != PermissionState.GRANTED) {
            requestPermissionForAlias("storage", call, "storagePermsCallback");
        } else {
            String nombre=call.getString("name");
            String ruta = call.getString("uri");
            Log.i("MetaDataMp3", "Nombre del archivo a obtener la MetaData: " +nombre);
            Log.i("MetaDataMp3", "Ruta del archivo a obtener la MetaData: " +ruta);
            JSObject respuesta=implementation.getMetaData(ruta);
            call.resolve(respuesta);
        }

    }
}
