# Weather App - Aplicativo Android de Previsão do Tempo

Um aplicativo Android moderna desenvolvido em **Kotlin** com **Jetpack Compose** que fornece previsão do tempo em tempo real com integração a mapas, autenticação Firebase e armazenamento local de dados.

## 📱 Características Principais

### Autenticação e Gerenciamento de Usuários
- **Firebase Authentication**: Autenticação segura de usuários
- **Login e Registro**: Telas dedicadas para autenticação
- **Persistência de Sessão**: Mantém usuário logado automaticamente

### Previsão do Tempo
- **API de Clima em Tempo Real**: Integração com WeatherAPI para dados atualizados
- **Previsão Estendida**: Visualize previsões futuras
- **Monitoramento Automático**: Background Worker para atualizar previsões periodicamente
- **Múltiplas Cidades**: Gerencie e alterne entre diferentes cidades

### Interface do Usuário
- **Jetpack Compose**: UI moderna e reativa
- **Material Design 3**: Design components seguindo as últimas guidelines
- **Navegação**: Sistema de navegação com BottomNavBar
- **Mapa Integrado**: Google Maps para visualizar localização das cidades

### Armazenamento de Dados
- **Room Database**: Banco de dados local para cidades favoritas
- **Firebase Realtime Database**: Sincronização em nuvem de dados de usuários
- **Persistência Local**: Cache de informações

### Localização
- **Permissões de Localização**: ACCESS_FINE_LOCATION e ACCESS_COARSE_LOCATION
- **Google Play Services Location**: Integração com serviços de localização
- **Mapas Interativos**: Visualização de cidades no mapa

## 🏗️ Arquitetura do Projeto

### Estrutura de Pastas

```
app/src/main/java/com/example/pratica_jp/
├── api/                          # Camada de API
│   ├── APICondition.kt          # Condições climáticas
│   ├── APICurrentWeather.kt      # Clima atual
│   ├── APIForecast.kt            # Dados de previsão
│   ├── APIWeather.kt             # Informações de clima
│   ├── WeatherService.kt         # Serviço de API
│   └── WeatherServiceAPI.kt      # Interface Retrofit
├── db/                           # Camada de Banco de Dados
│   ├── fb/                       # Firebase
│   │   ├── FBCity.kt            # Modelo de cidade Firebase
│   │   ├── FBDatabase.kt        # Gerenciador Firebase
│   │   └── FBUser.kt            # Modelo de usuário Firebase
│   └── local/                    # Room Database
│       ├── LocalCity.kt          # Entidade de cidade local
│       ├── LocalCityDAO.kt       # Data Access Object
│       └── LocalRoomDatabase.kt  # Configração Room
├── model/                        # Modelos de Dados
│   ├── City.kt                   # Cidade
│   ├── Forecast.kt               # Previsão
│   ├── Weather.kt                # Clima
│   ├── User.kt                   # Usuário
│   ├── MainViewModel.kt          # ViewModel principal
│   └── MainViewModelFactory.kt   # Factory para ViewModel
├── monitor/                      # Monitoramento em Background
│   ├── ForecastMonitor.kt        # Monitor de previsões
│   └── ForecastWorker.kt         # WorkManager para atualizações
├── repo/                         # Camada de Repositório
│   └── Repository.kt             # Lógica de negócios centralizada
├── ui/                           # Camada de Apresentação
│   ├── HomePage.kt               # Página inicial
│   ├── ListPage.kt               # Lista de cidades
│   ├── MapPage.kt                # Mapa de cidades
│   ├── CityDialog.kt             # Diálogo para adicionar cidades
│   ├── nav/                      # Navegação
│   │   ├── BottomNavBar.kt       # Barra de navegação inferior
│   │   ├── BottomNavItem.kt      # Itens da barra
│   │   ├── MainNavHost.kt        # Host de navegação
│   │   └── Route.kt              # Definição de rotas
│   └── theme/                    # Tema da aplicação
│       ├── Color.kt              # Cores
│       ├── Theme.kt              # Configuração de tema
│       └── Type.kt               # Tipografia
├── LoginActivity.kt              # Tela de login
├── RegisterActivity.kt            # Tela de registro
├── MainActivity.kt               # Atividade principal
└── WeatherApp.kt                 # Classe Application
```

## 🛠️ Stack Tecnológico

### Kotlin & Android
- **Kotlin**: Linguagem principal (compilação para JVM 21)
- **Android SDK**: Min SDK 30, Target SDK 36
- **Jetpack Compose**: UI declarativa moderna

### Jetpack Components
- **Navigation Compose**: Sistema de navegação com Compose
- **Room Database**: Persistência local de dados
- **ViewModel & LiveData**: Gerenciamento de estado
- **WorkManager**: Agendamento de tarefas em background

### Serviços Externos
- **Firebase Authentication**: Autenticação de usuários
- **Firebase Realtime Database**: Sincronização em nuvem
- **WeatherAPI**: Dados de previsão do tempo
- **Google Maps**: Visualização de localização
- **Google Play Services**: Serviços de localização

### Bibliotecas
- **Retrofit**: Cliente HTTP para chamadas de API
- **Gson**: Serialização JSON
- **Coil**: Carregamento de imagens
- **Maps Compose**: Integration do Google Maps com Compose
- **Kotlinx Serialization**: Serialização de dados
- **KSP**: Kotlin Symbol Processing

## 📋 Dependências Principais

```kotlin
// Jetpack
- androidx.compose.bom
- androidx.lifecycle:lifecycle-viewmodel-compose
- androidx.navigation:navigation-compose
- androidx.room:room-runtime & room-ktx

// Google
- com.google.firebase:firebase-auth
- com.google.android.gms:play-services-maps
- com.google.maps.android:maps-compose

// Networking
- com.squareup.retrofit2:retrofit
- com.squareup.retrofit2:converter-gson

// UI
- io.coil-kt:coil-compose
- com.google.android.material:material

// Serialization
- org.jetbrains.kotlinx:kotlinx-serialization-json
```

## 🔐 Configuração

### local.properties
Adicione a seguinte variável no arquivo `local.properties` da raiz do projeto:

```properties
WEATHER_API_KEY=sua_chave_api_aqui
```

A chave é carregada em tempo de compilação via `buildConfigField` e está disponível como `BuildConfig.WEATHER_API_KEY`.

### Firebase
O projeto está configurado com Firebase. Certifique-se de ter o arquivo `google-services.json` na pasta `app/` com suas credenciais do Firebase.

## 🚀 Como Executar

### Pré-requisitos
- Java 21 ou superior
- Android Studio Koala ou superior
- SDK Android 36
- Gradle 8.6+

### Passos

1. **Clone ou abra o projeto**
   ```bash
   cd /workspaces/Android_development
   ```

2. **Instale as dependências**
   ```bash
   ./gradlew build
   ```

3. **Configure local.properties**
   Crie ou edite `local.properties` com sua chave de API:
   ```properties
   WEATHER_API_KEY=sua_chave_api_aqui
   ```

4. **Execute o aplicativo**
   ```bash
   ./gradlew installDebug
   ```
   Ou execute via Android Studio (Run > Run 'app')

## 🏗️ Padrões Arquiteturais

### MVVM (Model-View-ViewModel)
- **Model**: Classes de dados em `model/`
- **View**: Composables em `ui/`
- **ViewModel**: `MainViewModel` gerencia estado e lógica

### Repository Pattern
- `Repository.kt` centraliza acesso a dados
- Abstrai detalhes de Firebase e Room Database
- Fornece interface única para dados

### Separation of Concerns
- **api/**: Chamadas HTTP
- **db/**: Persistência (Firebase + Room)
- **model/**: Entidades de dados
- **ui/**: Componentes visuais
- **repo/**: Lógica de negócios

## 📡 Fluxo de Dados

```
UI (Composables) 
    ↓
ViewModel (MainViewModel)
    ↓
Repository
    ├→ WeatherService (API)
    ├→ FirebaseDatabase (Cloud)
    └→ RoomDatabase (Local)
```

## 🔄 Funcionalidades de Background

### ForecastWorker
- Atualiza previsões periodicamente
- Usa WorkManager para agendamento
- Sincroniza com o banco de dados local

### ForecastMonitor
- Monitora mudanças nas previsões
- Gerencia notificações (POST_NOTIFICATIONS)

## 📱 Permissões Requeridas

```xml
<!-- Localização -->
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />

<!-- Notificações -->
<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
```

## 🎨 Tema e UI

- **Material Design 3**: Design moderno e responsivo
- **Dark Mode Support**: Adapta-se ao tema do sistema
- **Compose Navigation**: Navegação smooth entre telas
- **BottomNavBar**: Navegação principal entre seções

## 📊 Versão

- **Código**: 1
- **Nome**: 1.0
- **Min SDK**: 30
- **Target SDK**: 36

## 🔌 API Endpoints

O projeto integra-se com **WeatherAPI** (https://www.weatherapi.com/):
- Clima atual
- Previsão de múltiplos dias
- Dados de localização

## 🛡️ Security

- **Secrets Gradle Plugin**: Google Maps API key gerenciada com secrets
- **ProGuard/R8**: Code obfuscation habilitado para build release
- **Firebase Security**: Rules de segurança do Firebase

## 📝 Build Configuration

```gradle
- compileSdk: 36
- minSdk: 30
- targetSdk: 36
- jvmTarget: JVM 21
- Kotlin Compiler: 1.5.3
```

## 🚧 Status

Aplicativo em desenvolvimento ativo com integração completa de:
- ✅ Autenticação Firebase
- ✅ API de clima em tempo real
- ✅ Banco de dados local (Room)
- ✅ Google Maps
- ✅ Background Workers
- ✅ Material Design 3

## 📞 Contato e Suporte

Para dúvidas sobre o projeto, consulte a documentação:
- [Firebase Documentation](https://firebase.google.com/docs)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [WeatherAPI Documentation](https://www.weatherapi.com/docs/)
- [Google Maps Platform](https://developers.google.com/maps)

---

**Desenvolvido com Kotlin e Jetpack Compose** 🚀
