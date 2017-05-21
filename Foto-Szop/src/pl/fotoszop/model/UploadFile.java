package pl.fotoszop.model;


public class UploadFile
{
    private int id;
    private String fileName;
    private String url;
    private byte[] data;

    public UploadFile(int id, String fileName, String url, byte[] data) {
        this.id = id;
        this.fileName = fileName;
        this.url = url;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
