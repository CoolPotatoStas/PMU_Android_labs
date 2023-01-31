# PMU_Android_labs

## 5.1.2. Уведомление в строке состояния

Создать уведомление в строке состояния немного сложнее. Начиная с API 16, вместо устаревшего 
метода *getNotification()* следует использовать метод *build()*. Интересно, что если взглянуть 
на исходный код Android, то видно, что старый метод вызывает метод *build()*. Видимо, разработ-
чикам не понравилось имя метода, вот его и объявили устаревшим.  

Затем нужно сформировать уведомление с помощью специального менеджера. Ссылку на *NotificationМanager* 
можно получить через вьiзов метода *getSysternService()*, передав ему в качестве параметра строковую 
константу *NOTIFICATION - SERVICE*, определенную в классе *Context*.  

Выводится уведомление с помощью метода *notify()* - это своеобразный аналог
метода *show()* у параметра *тoast* из предыдущего примера (см. листинг 5.1). 
Взглянем на код с комментариями:

`
Notification.Builder builder = new Notification.Builder(context);
builder.setContentintent(contentintent)
// маленькое изображение
.setSrnallicon(R.drawaЫe.srnall)
// большое изображение
.setLargeicon(BitrnapFactory.decodeResource(res, R.drawaЫe.big))
/ / Только для Android 4.х, в х и 6.х не сработает
setTicker("Фaйл был зашифрован!")
.setWhen(System.currentTimeMillis())
.setAutoCancel(true)
// Заголовок уведомления
.setContentTitle("My program")
// Текст уведомления для Android 5.х, 6.х и более новых
.setContentText("Фaйл был зашифрован!");
Notification notification = builder.build( ) ;
NotificationМanager tificationМanager = (NotificationМanager) context
.getSystemServi e(Context.NOТIFICATION_SERVICE);
notificationМanager.notify(NOTIFY_ID, notification);
`



## 5.1.3. Каналы уведомлений в Android 9.0



## 5.1.4. Определение действия уведомления



## 5.1.5. Кнопки действия



## 5.1.6. Удаление собственных уведомлений



## 5.1.7. Звуковая, световая и вибросигнализация



## 5.1.8. Вывод длинного текста