package com.jbrandev.capacitor.metadatamp3;

import android.net.Uri;
import android.util.Log;

import com.getcapacitor.JSObject;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.TagField;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class metadatamp3 {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

    /**
     * Removes the "file://" prefix from the given URI string, if applicable.
     * If the given URI string doesn't have a "file://" prefix, it is returned unchanged.
     *
     * @param uriString the URI string to operate on
     * @return a path without the "file://" prefix
     */
    public static String stripFileProtocol(String uriString) {
        if (uriString.startsWith("file://")) {
            return Uri.parse(uriString).getPath();
        }
        return uriString;
    }

    public JSObject getMetaData(String ruta)  {
        JSObject metadata = new JSObject();
        try {
            File archivoMp3=new File(stripFileProtocol(ruta));
            AudioFile file= AudioFileIO.read(archivoMp3);
            Tag tag= file.getTag();
            Log.i("MetaDataMp3", "Obtuvo las tags del archivo MP3 ");
            //ArrayList<JSObject> arrayMetaData=new ArrayList<>();
            ArrayList<MetaData> arrayMetaData=new ArrayList<>();
            arrayMetaData.add(new MetaData("CoverString", tag.getFirst(FieldKey.COVER_ART)));
            arrayMetaData.add(new MetaData("CoverField", tag.getFirstField(FieldKey.COVER_ART)));
            arrayMetaData.add(new MetaData("Album", tag.getFirst(FieldKey.ALBUM)));
            arrayMetaData.add(new MetaData("Artist", tag.getFirst(FieldKey.ARTIST)));
            arrayMetaData.add(new MetaData("Year", tag.getFirst(FieldKey.YEAR)));
            arrayMetaData.add(new MetaData("Track", tag.getFirst(FieldKey.TRACK)));
            arrayMetaData.add(new MetaData("Disk", tag.getFirst(FieldKey.DISC_NO)));
            arrayMetaData.add(new MetaData("Composer", tag.getFirst(FieldKey.COMPOSER)));
            arrayMetaData.add(new MetaData("ArtistSort", tag.getFirst(FieldKey.ARTIST_SORT)));
            arrayMetaData.add(new MetaData("Language", tag.getFirst(FieldKey.LANGUAGE)));
            arrayMetaData.add(new MetaData("Title", tag.getFirst(FieldKey.TITLE)));
            Log.i("MetaDataMp3", "Tags del archivo MP3 ");
            for (MetaData meta:arrayMetaData) {
                Log.i("MetaDataMp3", "Nombre: "+meta.name);
                Log.i("MetaDataMp3", "Value: "+meta.value);
            }
            metadata.put("data", arrayMetaData);
        }catch ( CannotReadException | TagException| InvalidAudioFrameException|
                ReadOnlyFileException| IOException e){
            Log.e("MetaDataMp3", "Error capturado al leer el archivo MP3 ");
            this.printError(e);
        }
        return metadata;
    }


    private void printError(Exception e){
        Log.e("MetaDataMp3", "Error capturado al leer el archivo MP3 ");
        Log.e("MetaDataMp3", ""+e.getClass());
        Log.e("MetaDataMp3", e.getMessage());
        Log.e("MetaDataMp3", ""+e.getCause());
        Log.e("MetaDataMp3", e.getLocalizedMessage());
        Log.e("MetaDataMp3", ""+e.getStackTrace());
    }
}
