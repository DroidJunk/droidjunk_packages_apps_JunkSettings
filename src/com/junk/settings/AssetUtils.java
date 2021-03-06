/*
 * Copyright (C) 2008 Esmertec AG.
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.junk.settings;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.content.Context;

public class AssetUtils {
    
    public static boolean copyAsset(Context context, String fromFile, String toFile) throws IOException {
    
    	InputStream in = context.getAssets().open(fromFile);
    	OutputStream out = new FileOutputStream(toFile);
    	try {
    	    byte[] buffer = new byte[1024];
    	    int read;
    	    while((read = in.read(buffer)) != -1){
    	      out.write(buffer, 0, read);
    	    }
    	} catch (IOException ex) {
    		ex.printStackTrace();
    		return false;
    	} finally {
    		try {
    			if (in != null)
    				in.close();
    			if (out != null)
    				out.close();

    		} catch (IOException ex) {
        		ex.printStackTrace();
        		return false;
        	}
    	}
		return true;
  	}
    
    
    
    
}
