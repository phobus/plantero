ng new plantero --style=scss --routing=true
cd plantero

ng generate module core
ng generate module data

mkdir -p src/app/layout
ng generate component layout/header
ng generate component layout/footer

mkdir src/app/modules

ng generate module shared

mkdir -p src/styles/themes

npm install bootstrap jquery popper.js
