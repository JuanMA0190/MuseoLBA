package com.museolba.utils;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;


public class CopiarTextoURLUtils {
    
    public static void copiarTexto(String url){
        if (url != null && !url.isEmpty()) {
            copiarEnElPortapapeles(url);
            DialogoUtils.mostrarMensaje("Texto copiado: " + url,1,"Texto copiado!");
        }
    }
    
    private static void copiarEnElPortapapeles(String text) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection seleccion = new StringSelection(text);
        clipboard.setContents(seleccion, null);
    }
}
