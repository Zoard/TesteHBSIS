TesteHBSIS

--- Sobre a Arquitetura ---

-   Procurei estudar os conceitos de MVVM para Android, visto que após o lançamento do Jetpack, este parece ser o melhor padrão a ser seguido.
-   Neste projeto separei os conceitos de View, Model e ViewModel para todas as Views do projeto. Inclusive as Views que são items das 2 Recycler Views contidas no projeto. 
-   Para "amarrar" as Views ao ViewModel, utilizei o DataBinding do Android, aliado ao LiveData para notificar as mudanças de estado do aplicativo. Além de evitar Memory Leak que pode ocorrer em Observables.
-   Foi utilizado também o RxJava nas requisições HTTP em conjunto com o cliente Retrofit para consumo de APIs.
-   Existem basicamente 3 Activities. Cada uma delas se comunica com uma respectiva ViewModel.
-   2 Activities (CurrentWeatherActivity e WeatherForecastActivity) possuem 2 Listas dinâmicas criadas pelo componente RecyclerView. Cada RecyclerView possui um Adapter e um ViewHolder referente à elas. Cada RecyclerView possui um ViewModel para tratar eventos referentes aos seus items.

--- O que faltou -> O que faria ---

-   Persistência dos dados na falta de rede -> Utilizaria o Room (DataBinding + LiveData + Room)
-   Carregamento dos ícones de Previsão de Tempo -> Tentei Utilizar o Glide, mas tive problemas de compilação
-   Faltou tratar eventos para alertar usuário, como nome de cidade inválido -> Utilizaria AlertDialogs
-   Faltou realização de Testes -> Iria estudar o Espresso 
