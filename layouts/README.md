## Lista de Exercícios – Android com Java: ViewGroups e Widgets

### O que é uma View no Android Framework?

É um componente básico da interface do usuário. Ela representa elementos visuais como botões, caixas de texto, imagens, entre outros. Cada item que o usuário vê e interage na tela é uma View.

### O que é um ViewGroup no contexto da interface do Android?

É um tipo de View que pode conter outras Views (inclusive outros ViewGroups). Ele funciona como um container que organiza e posiciona seus elementos filhos na tela, seguindo certas regras de layout.

### Qual é a função dos LayoutParams dentro de um ViewGroup?

Os LayoutParams são responsáveis por definir como uma View deve se comportar dentro de um ViewGroup. Através deles, é possível configurar propriedades como largura, altura, margens e outras regras de posicionamento.

### Por que diferentes ViewGroups (como LinearLayout, ConstraintLayout, FrameLayout) utilizam subclasses específicas de LayoutParams?

Cada ViewGroup organiza suas Views de maneira diferente, então precisa de informações específicas para fazer isso. Por isso, cada um tem sua própria subclasse de LayoutParams com atributos personalizados.
Por exemplo, o LinearLayout usa o atributo "weight" para dividir espaço entre os elementos, enquanto o ConstraintLayout precisa de informações de restrição para alinhar as Views.

