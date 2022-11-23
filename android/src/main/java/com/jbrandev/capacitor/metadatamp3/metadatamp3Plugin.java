package com.jbrandev.capacitor.metadatamp3;

import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "metadatamp3")
public class metadatamp3Plugin extends Plugin {

    private metadatamp3 implementation = new metadatamp3();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");


        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void getMetadata(PluginCall call){
        String nombre=call.getString("name");
        String ruta = call.getString("uri");
        Log.i("MetaDataMp3", "Nombre del archivo a obtener la MetaData: " +nombre);
        Log.i("MetaDataMp3", "Ruta del archivo a obtener la MetaData: " +ruta);
        JSObject respuesta=implementation.getMetaData(ruta);
        call.resolve(respuesta);
    }
}
