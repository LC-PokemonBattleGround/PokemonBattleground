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

# Modifications lié au principe  :
- Ajout de nouveau fichiers de classes pour décomposer notre ancien controller qui s'occupait de tout faire
- Ajout d'un dossier pour stocker des utils à savoir des fonctions logiques qui figuraient aussi dans le controller
- Changement du nom du controlleur initiale pour le transformer en 1 classe avec 1 seule réponsabilité (avant il s'occupait de gérer l'affichage, le calcul, ...)
- Création de nouveaux fichiers pour respect du premier principe SOLID SRP (résponsabilité unique) 
- Pas de code ouvert à l'évolution et fermé à la modification au travers de l'usage d'énumération ou d'interface mais compréhension de l'appliquer au prochain projet
- Notre projet n'utilise pas l'héritage donc pas de nécessité d'appliquer le principes LSP (substitution de liskov)
- L'interface existante est restreinte au CRUD de pokemon, donc respect du principe ISP (ségrégation des interfaces)
- Notre projet n'utilise pas de composant de haut et bas niveau, donc pas de nécessité du respect du principe DIP (inversion de dépendance)
- Ajout d'une interface pour faciliter les mises à niveau futur des méthodes de la classe pokemon
