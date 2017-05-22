package pl.fotoszop.dao;


import pl.fotoszop.model.UploadFile;

public interface IFileUpload
{
    void uploadFile(UploadFile uploadFile, int clientId, int accountId);
}
