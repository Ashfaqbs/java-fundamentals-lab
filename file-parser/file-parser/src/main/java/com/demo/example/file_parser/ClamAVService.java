package com.demo.example.file_parser;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.Socket;

@Service
class ClamAVService {

    @Value("${clamav.host:localhost}")
    private String clamAVHost;

    @Value("${clamav.port:3310}")
    private int clamAVPort;

    public boolean scanFile(byte[] fileContent) {
        try (Socket socket = new Socket(clamAVHost, clamAVPort)) {
            socket.getOutputStream().write("zINSTREAM\0".getBytes());
            byte[] buffer = new byte[2048];

            int offset = 0;
            while (offset < fileContent.length) {
                int chunkSize = Math.min(fileContent.length - offset, 1024);
                byte[] chunkHeader = intToBytes(chunkSize);
                socket.getOutputStream().write(chunkHeader);
                socket.getOutputStream().write(fileContent, offset, chunkSize);
                offset += chunkSize;
            }

            // Send zero-length chunk to mark end of file
            socket.getOutputStream().write(new byte[]{0, 0, 0, 0});

            // Read response from ClamAV
            int bytesRead = socket.getInputStream().read(buffer);
            String response = new String(buffer, 0, bytesRead);
            return response.contains("FOUND");
        } catch (IOException e) {
            throw new RuntimeException("ClamAV scanning failed.", e);
        }
    }

    private byte[] intToBytes(int value) {
        return new byte[]{
                (byte) ((value >> 24) & 0xFF),
                (byte) ((value >> 16) & 0xFF),
                (byte) ((value >> 8) & 0xFF),
                (byte) (value & 0xFF)
        };
    }
}
