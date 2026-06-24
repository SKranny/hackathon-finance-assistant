package com.finance.assistant.data.objectbox.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\'\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0007H\u00c6\u0003J\t\u0010*\u001a\u00020\tH\u00c6\u0003J\t\u0010+\u001a\u00020\u0007H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003JY\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u00c6\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000204J\t\u00106\u001a\u00020\tH\u00d6\u0001J\t\u00107\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016\u00a8\u00068"}, d2 = {"Lcom/finance/assistant/data/objectbox/entity/UserProfileEntity;", "", "id", "", "name", "", "salary", "", "salaryDay", "", "balance", "nextSalaryDate", "createdAt", "updatedAt", "(JLjava/lang/String;DIDJJJ)V", "getBalance", "()D", "setBalance", "(D)V", "getCreatedAt", "()J", "setCreatedAt", "(J)V", "getId", "setId", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getNextSalaryDate", "setNextSalaryDate", "getSalary", "setSalary", "getSalaryDay", "()I", "setSalaryDay", "(I)V", "getUpdatedAt", "setUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "getCreatedAtAsLocalDate", "Ljava/time/LocalDate;", "getNextSalaryDateAsLocalDate", "hashCode", "toString", "app_debug"})
@io.objectbox.annotation.Entity()
public final class UserProfileEntity {
    @io.objectbox.annotation.Id()
    private long id;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    private double salary;
    private int salaryDay;
    private double balance;
    private long nextSalaryDate;
    private long createdAt;
    private long updatedAt;
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final double component3() {
        return 0.0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final long component6() {
        return 0L;
    }
    
    public final long component7() {
        return 0L;
    }
    
    public final long component8() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.data.objectbox.entity.UserProfileEntity copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, double salary, int salaryDay, double balance, long nextSalaryDate, long createdAt, long updatedAt) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    public UserProfileEntity(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, double salary, int salaryDay, double balance, long nextSalaryDate, long createdAt, long updatedAt) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    public final void setId(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final double getSalary() {
        return 0.0;
    }
    
    public final void setSalary(double p0) {
    }
    
    public final int getSalaryDay() {
        return 0;
    }
    
    public final void setSalaryDay(int p0) {
    }
    
    public final double getBalance() {
        return 0.0;
    }
    
    public final void setBalance(double p0) {
    }
    
    public final long getNextSalaryDate() {
        return 0L;
    }
    
    public final void setNextSalaryDate(long p0) {
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public final void setCreatedAt(long p0) {
    }
    
    public final long getUpdatedAt() {
        return 0L;
    }
    
    public final void setUpdatedAt(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate getNextSalaryDateAsLocalDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate getCreatedAtAsLocalDate() {
        return null;
    }
    
    public UserProfileEntity() {
        super();
    }
}