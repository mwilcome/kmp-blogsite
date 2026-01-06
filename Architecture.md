### Key Guidelines

- **Architecture**: Clean layers – Domain (pure logic/models), Data (repos/sources/mappers), Presentation (UI/ViewModels/MVI). Layers depend inward (Presentation/Data → Domain).
- **Organization**: Feature-first (e.g., `book/` folder contains all layers for "book" feature). Core utilities in `core/`.
- **MVI**: Immutable `State` data classes, sealed `Action` interfaces, ViewModels with StateFlow/Coroutines.
- **Data Handling**: Offline-first – Local DB (SQLDelight) checked before remote (Ktor). Use `Result<T, E>` for errors.
- **DI**: Koin for injecting repos, clients, etc. Shared + platform modules.
- **Multiplatform**: `expect/actual` for platform-specifics (e.g., HTTP engine: Ktor's JsClient for web).
- **Web Specifics**: Canvas-based UI via Compose for Web. Entry in `webMain/Main.kt` with `ComposeViewport`. No DOM manipulation; keep UI in `commonMain`.

#### Naming Conventions
- Features: lowercase (e.g., `book`).
- Layers: lowercase singular (e.g., `domain`, `data`, `presentation`).
- Models: PascalCase (e.g., `Book`).
- Entities/DTOs: End with `Entity`/`Dto` (e.g., `BookEntity`, `BookDto`).
- Repos: End with `Repository` (interface), `Default[Name]Repository` (impl).
- DataSources: End with `DataSource` (e.g., `RemoteBookDataSource`).
- ViewModels: `[Screen]ViewModel` (e.g., `BookListViewModel`).
- States/Actions: `[Screen]State`/`[Screen]Action` (e.g., `BookListState`).
- Screens: `[Screen]Screen` (e.g., `BookListScreen.kt`).
- Components: Descriptive CamelCase (e.g., `SearchBar`).
- Errors: Sealed `DataError` with subseals (e.g., `Local`, `Network`).
- Mappers: Extension functions in `mapper/` (e.g., `fun BookDto.toBook(): Book`).

- **Dependencies** (in `build.gradle.kts`): Kotlin Multiplatform, Compose Multiplatform, Ktor, Koin, SQLDelight, Coroutines, etc. Enable `wasmJs` target.
- **Testing**: Add unit tests in `commonTest` for domain/repos.
- **Resources**: Shared strings/images in `commonMain/composeResources/`.

### Full Folder Structure

```
[ProjectName]/
├── composeApp/                  # Shared CMP module (core logic/UI)
│   ├── src/
│   │   ├── commonMain/          # Shared across all platforms
│   │   │   ├── kotlin/
│   │   │   │   ├── [feature]/   # e.g., book/ - Repeat for each feature
│   │   │   │   │   ├── domain/
│   │   │   │   │   │   ├── model/
│   │   │   │   │   │   │   └── [Model].kt               # e.g., Book.kt
│   │   │   │   │   │   └── repository/
│   │   │   │   │   │       └── [Feature]Repository.kt   # Interface, e.g., BookRepository.kt
│   │   │   │   │   ├── data/
│   │   │   │   │   │   ├── local/
│   │   │   │   │   │   │   ├── dao/
│   │   │   │   │   │   │   │   └── [Dao].kt             # e.g., BookDao.kt
│   │   │   │   │   │   │   ├── entity/
│   │   │   │   │   │   │   │   └── [Entity].kt          # e.g., BookEntity.kt
│   │   │   │   │   │   │   └── database/
│   │   │   │   │   │   │       ├── [Database].kt        # e.g., AppDatabase.kt (expect)
│   │   │   │   │   │   │       └── DatabaseFactory.kt   # expect class for creation
│   │   │   │   │   │   ├── remote/
│   │   │   │   │   │   │   ├── dto/
│   │   │   │   │   │   │   │   └── [Dto].kt             # e.g., BookDto.kt
│   │   │   │   │   │   │   └── datasource/
│   │   │   │   │   │   │       └── Remote[Feature]DataSource.kt  # e.g., RemoteBookDataSource.kt
│   │   │   │   │   │   ├── repository/
│   │   │   │   │   │   │   └── Default[Feature]Repository.kt     # Impl, e.g., DefaultBookRepository.kt
│   │   │   │   │   │   └── mapper/
│   │   │   │   │   │       └── [Extensions].kt          # e.g., BookMapper.kt
│   │   │   │   │   ├── presentation/
│   │   │   │   │   │   ├── screens/
│   │   │   │   │   │   │   ├── [screen]/
│   │   │   │   │   │   │   │   ├── [Screen]Screen.kt    # e.g., BookListScreen.kt
│   │   │   │   │   │   │   │   ├── [Screen]ViewModel.kt # e.g., BookListViewModel.kt
│   │   │   │   │   │   │   │   ├── [Screen]State.kt     # e.g., BookListState.kt
│   │   │   │   │   │   │   │   └── [Screen]Action.kt    # e.g., BookListAction.kt
│   │   │   │   │   │   ├── components/
│   │   │   │   │   │   │   └── [Component].kt           # e.g., SearchBar.kt
│   │   │   │   │   │   └── viewmodel/                   # Shared VMs if needed
│   │   │   │   │   │       └── [Shared]ViewModel.kt     # e.g., SelectedItemViewModel.kt
│   │   │   │   │   └── di/                              # Feature DI if complex
│   │   │   │   │       └── [Feature]Module.kt           # e.g., BookModule.kt
│   │   │   │   ├── core/
│   │   │   │   │   ├── domain/
│   │   │   │   │   │   ├── Result.kt                    # Success/Error wrapper
│   │   │   │   │   │   └── DataError.kt                 # Sealed errors
│   │   │   │   │   ├── data/
│   │   │   │   │   │   └── HttpClientFactory.kt         # Shared HTTP setup (expect)
│   │   │   │   │   ├── presentation/
│   │   │   │   │   │   └── UiText.kt                    # String resource wrapper
│   │   │   │   │   ├── di/
│   │   │   │   │   │   └── AppModule.kt                 # Core/shared DI
│   │   │   │   │   └── navigation/
│   │   │   │   │       ├── Route.kt                     # Sealed routes
│   │   │   │   │       └── NavGraph.kt                  # NavHost setup
│   │   │   │   └── App.kt                               # Root @Composable
│   │   │   └── resources/                               # Shared assets
│   │   │       └── composeResources/
│   │   │           ├── drawable/                        # Images
│   │   │           └── values/
│   │   │               └── strings.xml                  # Strings
│   │   ├── wasmJsMain/          # Web-specific (WasmJs target)
│   │   │   └── kotlin/
│   │   │       ├── platform/    # Actuals for web
│   │   │       │   └── PlatformModule.kt                # Web DI (e.g., JsClient engine)
│   │   │       └── [feature]/   # Web-specific data/UI if needed
│   │   ├── webMain/             # Common web (JS/Wasm shared)
│   │   │   └── kotlin/
│   │   │       └── Main.kt                              # Web entry: ComposeViewport { App() }
│   │   ├── androidMain/         # Optional Android actuals
│   │   ├── desktopMain/         # Optional Desktop
│   │   └── iosMain/             # Optional iOS
│   └── build.gradle.kts         # Module config: plugins, targets (wasmJs), deps
├── androidApp/                  # Optional Android launcher
├── desktopApp/                  # Optional Desktop launcher
├── iosApp/                      # Optional iOS
├── build.gradle.kts             # Root build
├── settings.gradle.kts          # Includes modules
├── gradle.properties
└── README.md
```

### Detailed File Purposes and Expected Contents

For each major file/directory, here's what it does, naming, and sample contents (high-level; expand in code gen). Use Kotlin 1.9+, Compose 1.5+.

- **`[feature]/domain/model/[Model].kt`** (e.g., `Book.kt`):  
  **Purpose**: Pure domain model. Immutable data class for business entities.  
  **Contents**: `data class Book(val id: String, val title: String, val description: String? = null, ...)` – No deps.

- **`[feature]/domain/repository/[Feature]Repository.kt`** (e.g., `BookRepository.kt`):  
  **Purpose**: Interface for data ops. Returns Flows/Results for async/error handling.  
  **Contents**: `interface BookRepository { suspend fun searchBooks(query: String): Result<List<Book>, DataError>; fun getFavorites(): Flow<List<Book>>; ... }`

- **`[feature]/data/local/dao/[Dao].kt`** (e.g., `BookDao.kt`):  
  **Purpose**: SQLDelight queries for local DB.  
  **Contents**: `interface BookDao { fun insert(book: BookEntity); fun getAll(): Flow<List<BookEntity>>; ... }`

- **`[feature]/data/local/entity/[Entity].kt`** (e.g., `BookEntity.kt`):  
  **Purpose**: DB table entity.  
  **Contents**: `data class BookEntity(val id: String, val title: String, ...)`

- **`[feature]/data/local/database/[Database].kt`** (e.g., `AppDatabase.kt`):  
  **Purpose**: SQLDelight DB definition.  
  **Contents**: `expect class AppDatabase(schema: Schema) { val bookDao: BookDao }`

- **`[feature]/data/local/database/DatabaseFactory.kt`**:  
  **Purpose**: expect class for platform-specific DB init.  
  **Contents**: `expect class DatabaseFactory() { fun createDatabase(): AppDatabase }`

- **`[feature]/data/remote/dto/[Dto].kt`** (e.g., `BookDto.kt`):  
  **Purpose**: API response models (Serializable).  
  **Contents**: `@Serializable data class BookDto(val key: String, val name: String, ...)`

- **`[feature]/data/remote/datasource/Remote[Feature]DataSource.kt`** (e.g., `RemoteBookDataSource.kt`):  
  **Purpose**: Ktor API calls.  
  **Contents**: `class RemoteBookDataSource(private val client: HttpClient) { suspend fun search(query: String): Result<List<BookDto>, DataError.Remote> { try { client.get("api/url?q=$query").content.toJson() } catch (e: Exception) { Result.Error(...) } } }`

- **`[feature]/data/repository/Default[Feature]Repository.kt`** (e.g., `DefaultBookRepository.kt`):  
  **Purpose**: Repo impl – combines local/remote, offline-first.  
  **Contents**: `class DefaultBookRepository(private val local: BookDao, private val remote: RemoteBookDataSource) : BookRepository { override suspend fun searchBooks(query: String): Result<List<Book>, DataError> { // Check local first, then remote, cache } }`

- **`[feature]/data/mapper/[Extensions].kt`** (e.g., `BookMapper.kt`):  
  **Purpose**: Conversions.  
  **Contents**: `fun BookDto.toBook(): Book = Book(id = key, title = name, ...); fun Book.toEntity(): BookEntity = ...`

- **`[feature]/presentation/screens/[screen]/[Screen]Screen.kt`** (e.g., `BookListScreen.kt`):  
  **Purpose**: `@Composable` UI.  
  **Contents**: `@Composable fun BookListScreen(viewModel: BookListViewModel = koinViewModel()) { val state = viewModel.state.collectAsState().value; Column { SearchBar(onQueryChange = { viewModel.onAction(BookListAction.QueryChange(it)) }); LazyColumn { items(state.books) { BookItem(it) } } } }`

- **`[feature]/presentation/screens/[screen]/[Screen]ViewModel.kt`** (e.g., `BookListViewModel.kt`):  
  **Purpose**: Manages state/actions with coroutines.  
  **Contents**: `class BookListViewModel(private val repo: BookRepository) : ViewModel() { private val _state = MutableStateFlow(BookListState()); val state = _state.asStateFlow(); fun onAction(action: BookListAction) { when (action) { is QueryChange -> viewModelScope.launch { repo.searchBooks(action.query).onSuccess { _state.update { it.copy(books = it) } } } } } }`

- **`[feature]/presentation/screens/[screen]/[Screen]State.kt`** (e.g., `BookListState.kt`):  
  **Purpose**: Immutable UI state.  
  **Contents**: `data class BookListState(val books: List<Book> = emptyList(), val isLoading: Boolean = false, val error: UiText? = null)`

- **`[feature]/presentation/screens/[screen]/[Screen]Action.kt`** (e.g., `BookListAction.kt`):  
  **Purpose**: User intents.  
  **Contents**: `sealed interface BookListAction { data class QueryChange(val query: String) : BookListAction; object Refresh : BookListAction }`

- **`[feature]/presentation/components/[Component].kt`** (e.g., `SearchBar.kt`):  
  **Purpose**: Reusable UI.  
  **Contents**: `@Composable fun SearchBar(onQueryChange: (String) -> Unit) { TextField(...) }`

- **`core/domain/Result.kt`**:  
  **Contents**: `sealed class Result<out T, out E> { data class Success<out T>(val value: T) : Result<T, Nothing>(); data class Error<out E>(val error: E) : Result<Nothing, E>() }`

- **`core/domain/DataError.kt`**:  
  **Contents**: `sealed interface DataError { sealed interface Local : DataError { object DiskFull : Local }; sealed interface Remote : DataError { object Network : Remote } }`

- **`core/data/HttpClientFactory.kt`**:  
  **Contents**: `expect fun createHttpClient(): HttpClient` – Config with logging, JSON.

- **`core/presentation/UiText.kt`**:  
  **Contents**: `sealed class UiText { class StringResource(val resId: StringResource) : UiText(); class DynamicString(val value: String) : UiText() }`

- **`core/di/AppModule.kt`**:  
  **Contents**: `val appModule = module { single { createHttpClient() }; single<BookRepository> { DefaultBookRepository(get(), get()) } }` – Load in app entry.

- **`core/navigation/Route.kt`**:  
  **Contents**: `sealed class Route(val path: String) { object BookList : Route("book_list"); object BookDetail : Route("book_detail/{id}") }`

- **`core/navigation/NavGraph.kt`**:  
  **Contents**: `@Composable fun NavGraph(navController: NavHostController) { NavHost(navController, startDestination = Route.BookList.path) { composable(Route.BookList.path) { BookListScreen() } } }`

- **`App.kt`**:  
  **Purpose**: Root composable.  
  **Contents**: `@Composable fun App() { MaterialTheme { val navController = rememberNavController(); NavGraph(navController) } }`

- **`webMain/kotlin/Main.kt`**:  
  **Purpose**: Web entry.  
  **Contents**: `fun main() { startKoin { modules(appModule + platformModule) }; ComposeViewport(document.getElementById("root")!!) { App() } }`

- **`wasmJsMain/kotlin/platform/PlatformModule.kt`**:  
  **Purpose**: Web DI.  
  **Contents**: `val platformModule = module { single { DatabaseFactory().createDatabase() }; factory { createHttpClient() } }` – Use JsClient engine.

- **`build.gradle.kts` (composeApp)**:  
  **Contents**: Plugins: multiplatform, compose. Targets: `wasmJs { browser { ... } }`. Deps: `compose.runtime`, `compose.material3`, `ktor.client.js`, `koin`, `sqldelight.jsDriver`, etc.