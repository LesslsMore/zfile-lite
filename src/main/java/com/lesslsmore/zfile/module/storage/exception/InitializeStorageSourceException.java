package com.lesslsmore.zfile.module.storage.exception;

import com.lesslsmore.zfile.core.util.CodeMsg;

/**
 * 存储源初始化异常
 *
 * @author zhaojun
 */
public class InitializeStorageSourceException extends StorageSourceException {
    
    public InitializeStorageSourceException(CodeMsg codeMsg, Integer storageId, String message) {
        super(codeMsg, storageId, message);
    }
    
    public InitializeStorageSourceException(CodeMsg codeMsg, Integer storageId, String message, Throwable cause) {
        super(codeMsg, storageId, message, cause);
    }
    
}