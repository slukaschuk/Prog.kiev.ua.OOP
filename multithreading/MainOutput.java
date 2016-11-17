package multithreading;

import java.io.File;

public class MainOutput {
    private File f;
    private long flength;

    MainOutput(String filename) {
        this.f = new File(filename);
        this.flength = 0;
    }

    public File getfile() {
        return f;
    }

    public void setfile(File f) {
        this.f = f;
    }

    public void setFlength(long length) {
        this.flength = length;
    }

    public long getFlength() {
        return flength;
    }
}
