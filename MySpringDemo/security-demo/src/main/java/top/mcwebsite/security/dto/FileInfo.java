package top.mcwebsite.security.dto;

/**
 * @author mengchen
 * @time 18-7-30 上午8:44
 */
public class FileInfo {

    private String path;

    public FileInfo(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
