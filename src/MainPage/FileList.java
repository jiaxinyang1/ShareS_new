package MainPage;

import java.util.Objects;

public class FileList {
    private String fileNo;
    private String fileName;
    private String fileSize;
    private String uploadTime;
    private int    authority;
    private String fileURL;
    private String upLoader;

    public String getUpLoader() {
        return upLoader;
    }

    public void setUpLoader(String upLoader) {
        this.upLoader = upLoader;
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileList fileList = (FileList) o;
        return Objects.equals(fileNo, fileList.fileNo);
    }


}
