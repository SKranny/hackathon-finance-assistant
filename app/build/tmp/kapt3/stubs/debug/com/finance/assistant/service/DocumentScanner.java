package com.finance.assistant.service;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@\u00a2\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J \u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u000bH\u0082@\u00a2\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\nH\u0086@\u00a2\u0006\u0002\u0010\u001eJ\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\n2\u0006\u0010 \u001a\u00020\u000bH\u0082@\u00a2\u0006\u0002\u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/finance/assistant/service/DocumentScanner;", "", "context", "Landroid/content/Context;", "contentResolver", "Landroid/content/ContentResolver;", "(Landroid/content/Context;Landroid/content/ContentResolver;)V", "parsingLogic", "Lcom/finance/assistant/service/DocumentParsingLogic;", "scanFolders", "", "", "kotlin.jvm.PlatformType", "supportedExtensions", "textRecognizer", "Lcom/google/mlkit/vision/text/TextRecognizer;", "extractTextFromFile", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isImageUri", "", "isSupportedFile", "name", "mime", "processFile", "Lcom/finance/assistant/domain/model/Transaction;", "fileName", "(Landroid/net/Uri;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scanDocuments", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scanFolder", "folderType", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class DocumentScanner {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.ContentResolver contentResolver = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.mlkit.vision.text.TextRecognizer textRecognizer = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.service.DocumentParsingLogic parsingLogic = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> supportedExtensions = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> scanFolders = null;
    
    @javax.inject.Inject()
    public DocumentScanner(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.content.ContentResolver contentResolver) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object scanDocuments(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.finance.assistant.domain.model.Transaction>> $completion) {
        return null;
    }
    
    private final java.lang.Object scanFolder(java.lang.String folderType, kotlin.coroutines.Continuation<? super java.util.List<com.finance.assistant.domain.model.Transaction>> $completion) {
        return null;
    }
    
    private final boolean isSupportedFile(java.lang.String name, java.lang.String mime) {
        return false;
    }
    
    private final java.lang.Object processFile(android.net.Uri uri, java.lang.String fileName, kotlin.coroutines.Continuation<? super com.finance.assistant.domain.model.Transaction> $completion) {
        return null;
    }
    
    private final java.lang.Object extractTextFromFile(android.net.Uri uri, kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    private final boolean isImageUri(android.net.Uri uri) {
        return false;
    }
}