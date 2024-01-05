# Pokemon Battle ground
[Projet] - Application Web Spring
- Créé par Jonathan MARTIN et Simon BARTHE
- Application permettant l'ajout et la création de Pokémons
- Gestion de combats aléatoire entre Pokémons
- Serveur disponible sur TOMCAT connecté avec MariaDB ou MySQL (voir la configuration de connexion)
- CRUD de Pokémons.

## Spécifictées
Chaque Pokémon possède des PV (Points de Vie), des points d'Attaque (Puissance) et des Points de Défense (Résistance), ces 2 paramètres aident à calculer les PC (Points de Combat).
Chaque Pokémon possède un type qui affecte plus ou moins de dégats en fonction d'autres types (voir les règles de typage ci-dessous)
Les Points de Vie, d'attaque et de défense sont générés aléatoirement, les Points de Combats sont eux générés grâce à un calcul.

### Typage : 
1. Les pokémons de types <span style="color:blue">__Eau__</span> sont faibles face au Pokémons <span style="color:green">*Plante*</span> et efficace contre les types <span style="color:red">*Feu*</span>
2. Les pokémons de types <span style="color:red">__Feu__</span> sont faibles face au Pokémons <span style="color:blue">*Eau*</span> et efficace contre les types <span style="color:green">*Plante*</span>
3. Les pokémons de types <span style="color:green">__Plante__</span> sont faibles face au Pokémons <span style="color:red">*Feu*</span> et efficace contre les types <span style="color:blue">*Eau*</span>

## Délais
5 jours de développements avec l'inclusion d'un cahier des charges à rythme de 6 heures / jours.
### Version 1.0, Beta (2.0 en cours de développement ...)

# Analyse de nos anciens modèles de développement :

1. Problème <span style="color:lightcoral">__SRP__</span> : Nous avions un controller universel qui s'occupait de l'affichage, de la logique des calculs et de l'implémentation de service
2. Problème <span style="color:lightcoral">__OCP__</span> : Notre code ne permettait pas d'être ouvert à l'évolution et fermé à la modification car pas d'implémentation d'interface, de classe abstraiteet seulement une enumération
3. Problème <span style="color:lightcoral">__LSP__</span> : Notre projet sera compliqué à faire évolué sans utiliser l'héritage, c'est pourquoi il serait intéressant d'appliquer ce prinipe lors d'un modification qui y est lié
4. Problème <span style="color:lightcoral">__ISP__</span> : Nous n'avions pas d'interface pour certains objet, la création de celle ci est donc plus facile à mettre en place en respectant le principe de ségrégation des interfaces
5. Problème <span style="color:lightcoral">__DIP__</span> : Pas d'utilisation de composant de haut et bas niveau, il serait préférable de faire attention au respect de ce principe lors de modification futur

# Modifications lié au principe SOLID :
- Solution <span style="color:lightgreen">__SRP__</span> : Fragmentation du controller en plusieurs controller à responsabilité unique 
- Solution <span style="color:lightgreen">__OCP__</span> : Code ouvert à l'évolution et fermé à la modification au travers de l'usage d'énumération et d'interface (PokemonInterface)
- Solution <span style="color:lightblue">__LSP__</span> : Notre projet n'utilise pas l'héritage ni de sous classes donc pas de nécessité d'appliquer le principes LSP (substitution de liskov)
- Solution <span style="color:lightgreen">__ISP__</span> : Nos interfaces sont courtes et spécifique à certains besoin, rentrant donc en adéquation avec le principe de ségrégation des interfaces
- Solution <span style="color:lightblue">__DIP__</span> : Notre projet n'utilise pas de composant de haut et bas niveau, donc pas de nécessité du respect du principe DIP (inversion de dépendance)
