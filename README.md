# CityGuide

<p><strong>Тестовое задание:</strong>
</p>
<ol start="1" style="list-style-type: decimal;">
    <li>Сделать launch screen (отобразить любую иконку 64x64 в середине экрана)</li>
    <li>Разработать хранение поля &quot;SelectedCity&quot; в локальном хранилище приложения (Local Storage /&nbsp;
        UserDefaultsSettings).
    </li>
    <li>После launch screen вычитать поле из хранилища &quot;SelectedCity&quot; (описание SelectedCity ниже)</li>
    <li>Главный экран представляет из себя 3 вкладки: Страны, Избранное и Настройки
        <ol start="1" style="list-style-type: lower-alpha;">
            <li>Страны - вкладка является сложной таблицей с двумя уровнями
                <ol start="1" style="list-style-type: lower-roman;">
                    <li>Необходимо сделать запрос <a href="https://atw-backend.azurewebsites.net/api/countries">https://atw-backend.azurewebsites.net/api/countries</a>
                    </li>
                    <li>После получения данных первый уровень таблицы - Страны</li>
                    <li>При нажатии на определенную страну необходимо вывести список городов этой страны</li>
                    <li>Второй уровень можно скрывать и отображать нажимая на определенную страну</li>
                    <li>В ячейки города сделать иконку звезды, которая принимает 2 состояния: добавлено в избранное и не
                        добавлено. При нажатии иконки когда элемент уже является избранным происходит его удаление из
                        избранного. Если элемента в избранном нет - он добавляется.
                    </li>
                    <li>При нажатии на элемент в списке меняется и подсвечивается (фон ячейки - серый) SelectedCity</li>
                    <li>При инициализации необходимо также подсветить SelectedCity ячейку.</li>
                </ol>
            </li>
            <li>Избранное - список с элементами избранного из задания во вкладке Страны. Должен обновляться в случае
                изменения данных. Элемент из избранного можно удалить через иконку крестик в каждой ячейке списка.
                Статус избранного должен обновляться и во вкладке Страны.
            </li>
            <li>Настройки - сделать в середине вкладки надпись &quot;Настройки&quot;</li>
        </ol>
    </li>
</ol>
<p>Ответ: на выходе предоставить исходный код на Objective-C/Java/C#/Xamarin в git репозитории.
</p>
