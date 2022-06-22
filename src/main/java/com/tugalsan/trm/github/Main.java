package com.tugalsan.trm.github;
//WHEN RUNNING IN NETBEANS, ALL DEPENDENCIES SHOULD HAVE TARGET FOLDER!

import com.tugalsan.api.file.server.*;
import com.tugalsan.api.file.txt.server.*;
import com.tugalsan.api.pack.client.*;
import java.nio.file.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        forEachChild(Path.of("C:\\me\\codes\\com.tugalsan\\com.tugalsan.bat"));
        List.of(
                "C:\\me\\codes\\com.tugalsan\\api",
                "C:\\me\\codes\\com.tugalsan\\app",
                "C:\\me\\codes\\com.tugalsan\\lib",
                "C:\\me\\codes\\com.tugalsan\\lib",
                "C:\\me\\codes\\com.tugalsan\\res",
                "C:\\me\\codes\\com.tugalsan\\spi",
                "C:\\me\\codes\\com.tugalsan\\trm"
        ).stream().map(str -> Path.of(str)).forEachOrdered(parent -> {
            TS_DirectoryUtils.subDirectories(parent, false, false).forEach(child -> {
                forEachChild(child);
            });
        });
    }

    static void forEachChild(Path child) {
        textFiles.forEach(textFile -> {
            var file = child.resolve(textFile.value0);
            System.out.println("file: " + file);
            TS_FileTxtUtils.toFile(textFile.value1, file, false);
        });
    }
    static List<TGS_Pack2<String, String>> textFiles = List.of(
            TGS_Pack2.of(".gitattributes", """
                 # Auto detect text files and perform LF normalization
                 * text=auto
                 """),
            TGS_Pack2.of(".gitignore", """
                 */target/**
                 """)
    );
}
