package Controller.Server;

import Controller.ApiHandler.ApiHandler;
import com.sun.net.httpserver.*;

import java.io.*;
import java.net.InetSocketAddress;
import java.security.*;
import java.security.cert.CertificateException;

import javax.net.ssl.*;

public class Https extends Server{
    public Https() {
        port = 8989;
    }

    public Https(int port) {
        this.port = port;
    }

    public Https(Class<? extends ApiHandler> apiClass) {
        port = 8989;
        try {
            handler = apiClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Https(int port, Class<? extends ApiHandler> apiClass) {
        this.port = port;
        try {
            handler = apiClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Start() throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException,
            UnrecoverableKeyException, InterruptedException, KeyManagementException {
        com.sun.net.httpserver.HttpsServer server = com.sun.net.httpserver.HttpsServer.create(new InetSocketAddress(port), 5);
        server.createContext("/api", handler);

        char[] storepass = "storepass".toCharArray();
        char[] keypass = "serverpass".toCharArray();

        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(Https.class.getResourceAsStream("server.jks"), storepass);

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, keypass);

        KeyStore ts = KeyStore.getInstance("JKS");
        ts.load(this.getClass().getResourceAsStream("servertrust.jks"), storepass);
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(ts);

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

        server.setHttpsConfigurator(new HttpsConfigurator(sslContext) {
            public void configure (HttpsParameters params) {
                params.setWantClientAuth(true);
                params.setNeedClientAuth(true);
            }
        });
        server.setExecutor(null); // creates a default executor
        server.start();
    }
}