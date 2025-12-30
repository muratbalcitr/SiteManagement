package com.balancetech.sitemanagement.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJD\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010#2\u0006\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010#2\b\u0010*\u001a\u0004\u0018\u00010#J\u000e\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\u0013J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u0006\u0010)\u001a\u00020#H\u0086@\u00a2\u0006\u0002\u0010.J\u0014\u0010/\u001a\u00020!2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bJ\u000e\u00100\u001a\u00020!2\u0006\u0010)\u001a\u00020#J\u000e\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020#J\u0006\u00103\u001a\u00020!J\u000e\u00104\u001a\u00020!2\u0006\u0010,\u001a\u00020\u0013R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000b0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000b0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000b0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u00a8\u00065"}, d2 = {"Lcom/balancetech/sitemanagement/ui/viewmodel/UserViewModel;", "Landroidx/lifecycle/ViewModel;", "userRepository", "Lcom/balancetech/sitemanagement/data/repository/UserRepository;", "localDataSource", "Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;", "remoteDataSource", "Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;", "(Lcom/balancetech/sitemanagement/data/repository/UserRepository;Lcom/balancetech/sitemanagement/data/datasource/LocalDataSource;Lcom/balancetech/sitemanagement/data/datasource/RemoteDataSource;)V", "_blocks", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/balancetech/sitemanagement/data/entity/Block;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/balancetech/sitemanagement/ui/viewmodel/UserUiState;", "_units", "Lcom/balancetech/sitemanagement/data/entity/Unit;", "_users", "Lcom/balancetech/sitemanagement/data/entity/User;", "blocks", "Landroidx/lifecycle/LiveData;", "getBlocks", "()Landroidx/lifecycle/LiveData;", "uiState", "getUiState", "units", "getUnits", "users", "Lkotlinx/coroutines/flow/StateFlow;", "getUsers", "()Lkotlinx/coroutines/flow/StateFlow;", "createUser", "", "email", "", "password", "name", "phone", "role", "Lcom/balancetech/sitemanagement/data/model/UserRole;", "apartmentId", "unitId", "deleteUser", "user", "getAllUnits", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importUnits", "loadBlocks", "loadUnitsByBlock", "blockId", "loadUsers", "updateUser", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class UserViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.repository.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource = null;
    @org.jetbrains.annotations.NotNull
    private final com.balancetech.sitemanagement.data.datasource.RemoteDataSource remoteDataSource = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.balancetech.sitemanagement.ui.viewmodel.UserUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.balancetech.sitemanagement.ui.viewmodel.UserUiState> uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.balancetech.sitemanagement.data.entity.User>> _users = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.balancetech.sitemanagement.data.entity.User>> users = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.balancetech.sitemanagement.data.entity.Unit>> _units = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.balancetech.sitemanagement.data.entity.Unit>> units = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.balancetech.sitemanagement.data.entity.Block>> _blocks = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<com.balancetech.sitemanagement.data.entity.Block>> blocks = null;
    
    @javax.inject.Inject
    public UserViewModel(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.repository.UserRepository userRepository, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.LocalDataSource localDataSource, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.datasource.RemoteDataSource remoteDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.balancetech.sitemanagement.ui.viewmodel.UserUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.balancetech.sitemanagement.data.entity.User>> getUsers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.balancetech.sitemanagement.data.entity.Unit>> getUnits() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<com.balancetech.sitemanagement.data.entity.Block>> getBlocks() {
        return null;
    }
    
    public final void loadUsers() {
    }
    
    public final void loadBlocks(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId) {
    }
    
    public final void loadUnitsByBlock(@org.jetbrains.annotations.NotNull
    java.lang.String blockId) {
    }
    
    public final void createUser(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.String phone, @org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.model.UserRole role, @org.jetbrains.annotations.Nullable
    java.lang.String apartmentId, @org.jetbrains.annotations.Nullable
    java.lang.String unitId) {
    }
    
    public final void updateUser(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.User user) {
    }
    
    public final void deleteUser(@org.jetbrains.annotations.NotNull
    com.balancetech.sitemanagement.data.entity.User user) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAllUnits(@org.jetbrains.annotations.NotNull
    java.lang.String apartmentId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.balancetech.sitemanagement.data.entity.Unit>> $completion) {
        return null;
    }
    
    public final void importUnits(@org.jetbrains.annotations.NotNull
    java.util.List<com.balancetech.sitemanagement.data.entity.Unit> units) {
    }
}