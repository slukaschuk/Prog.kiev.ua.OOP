package Monit3;

public interface IFileEvents {
    void onFileChanged(String path);
    void onFileAdded(String path);
    void onFileDeleted(String path);
}
