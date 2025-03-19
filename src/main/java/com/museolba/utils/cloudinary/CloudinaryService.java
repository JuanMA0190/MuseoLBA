package com.museolba.utils.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.File;
import java.util.Map;

public class CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryService() {
        String cloudName = System.getenv("CLOUD_NAME");
        String apiKey = System.getenv("API_KEY");
        String apiSecret = System.getenv("API_SECRET");
        
        if (cloudName == null || apiKey == null || apiSecret == null) {
            throw new IllegalStateException("Cloudinary credentials are missing from environment variables");
        }
        
        cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", cloudName,
            "api_key", apiKey,
            "api_secret", apiSecret
        ));
    }

    public String subirImagen(String rutaLocal) throws Exception {
        File file = new File(rutaLocal);
        Map<?, ?> uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        return (String) uploadResult.get("url");
    }
}
