package org.rsimulator.proxy.recorder;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

/**
 * A HttpServletRequestWrapper which buffers data to a byte array
 *
 * @author Anders Bälter
 */
public class RecorderServletRequestWrapper extends HttpServletRequestWrapper {

    ByteArrayInputStream bais;

    ByteArrayOutputStream baos;

    BufferedServletInputStream bsis;

    byte[] buffer;

    public RecorderServletRequestWrapper(HttpServletRequest req) throws IOException {
        super(req);
        InputStream is = req.getInputStream();
        baos = new ByteArrayOutputStream();
        byte buffer[] = new byte[1024];
        int letti;
        while ((letti = is.read(buffer)) > 0) {
            baos.write(buffer, 0, letti);
        }
        this.buffer = baos.toByteArray();
    }

    @Override
    public ServletInputStream getInputStream() {
        try {
            bais = new ByteArrayInputStream(buffer);
            bsis = new BufferedServletInputStream(bais);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return bsis;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    /**
     * Get the request buffer as a String
     * @param encoding
     * @return String
     * @throws UnsupportedEncodingException
     */
    public String getRequestAsString(String encoding) throws UnsupportedEncodingException {
        return new String(buffer, encoding);
    }
}
