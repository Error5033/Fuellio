KAROLIS ZAKSAUSKAS (2209176)
Fuelio: 
GPS phone tracker & locator  

## App Description
Have you ever wondered where you can get the cheapest fuel in your area? Well stress no more, using Fuelio you can track and note down the best prices for your needs!




Fuelio is the world’s first app that the users can use to track fuel prices in their area, note them down and use for future reference of changes, in addition the app tracks precise co-ordinates so it can also be used to save locations that you wish to return to or even  find out exactly where you are if lost. 

## Functionality:
-	No sign up
-	Interactive user interface 
-	Navigation buttons (clearly labelled)
-	User input box      
-	GPS tracker 
-	Data transfer between pages
-	Notifications 
-	SQLite database
-	No internet requirement 
-	Usage of user data 
-	Display of current date
-	User input history



## Usability:
-	View real time location 
-	Create task
-	View all tasks
-	Edit tasks
-	See past location history 

-	Save any data in text format 
-	Share data with friends or family 
-	All data is saved for future reference 
-	Easy access to users
-	Sync data stored using RoomSQL




## Wireframe and Prototype:
![Picture2](https://user-images.githubusercontent.com/114151300/205933291-075c9f97-8c91-45cf-9967-f877dcce516d.png)
![Screenshot 2022-12-06 150447](https://user-images.githubusercontent.com/114151300/205947974-2c9a1f02-3da4-4ce6-bd88-3dc83679060b.png)


The navigation goes as follows: there are three pages within this application and when the app is opened the first page is displayed. When the user clicks the “add” button it takes them to the second page where they can see all the data from their input and when they click the back arrow it takes them back to the main page, page 1. When the user clicks “VIEW ALL” it takes them to the third page where they can see a history of all the previous inputs gathered from page 2 and they can return directly from page 3 to page 1 simply by pressing the back arrow key.








## User experience/usability:

The app is super simple and straight forward leaving no confusion for the user therefore no registration is required. When the user opens the app, they are instantly greeted with a simple yet effectively portrayed page where the  name of the app is displayed, there are buttons to interact with and text boxes to fill.45

![Picture3](https://user-images.githubusercontent.com/114151300/205933464-2f32f929-9fe2-4107-83b8-4047ba45307f.png)

- 	Petrol (1) 
- 	Diesel (2)
- 	LPG (3)
When one of the buttons gets selected it is highlighted in grey portraying to the user that its selected. 

![Screenshot 2022-12-06 140734](https://user-images.githubusercontent.com/114151300/205933715-3ba00c94-0848-40b2-8c72-b2471c10c343.png)

Directly under there are two boxes where users can input their post code (4) and the fuel price (5) if they choose, the user can put any data they like  and it will be saved, so it’s not bounded by one text type. Once that is done the user’s input is saved in a local database and displayed on a different page upon request. 

![image](https://user-images.githubusercontent.com/114151300/205933793-453dfc7d-8dc1-45e2-9392-ef4a76ee4ed3.png)

Moving down the page, there are 3 additional buttons (6,7,8)
each preforming a task, nicely labelled and hence self-explanatory.
When the user clicks the “GET GPS LOCATION” button (7), they will see a short loading animation and some text saying “collecting data” so the user knows that something is happening within the app, once it’s done the user will see a small notification that their GPS location is retrieved.



![Picture5](https://user-images.githubusercontent.com/114151300/205934131-4d7e39a2-eb77-4f9f-a708-46209f305df7.png)


Once the user has interacted with widgets 1 - 6 they can then click the “add button” (7), they will be prompted with a new window and a notification of “new record inserted”. This new window shows all the data that has been inputted from the user and displays it for the user in a nice format. When the user is done, they may click the back arrow (9) at the top of the page to return to main page.

![Picture6](https://user-images.githubusercontent.com/114151300/205934229-7112149f-9d57-47d9-b864-aca577bbe45d.png)


 If the user clicks the “View all” button (8)  they will see a list of all the previous interactions and their inputs.

he user is not required to interact with the previous widgets however if they don’t, the data will not be complete. It’s made this way for easier usability in case the user might not know all the details or chooses not to input certain data. 

Life cycle event:
Uses the “Views” function to ensure UI remains the same throughout the pages. 
Uses lifecycle listeners to store state of member variables and calls them via the “onViewCreated” function to call back.
- GetId
-	Return
-	onBindViewHolder
-	getItemCount
-	ViewHolder
-	onClick
-	perform
All my pages have the on Create function; it’s called when the activity is first created. Create views, bind data to lists, etc. This method also provides you with a bundle containing the activity's previously frozen state if there was one. 






Uses Firebase Realtime API, providing HTTP API for create, get, update, delete tasks, exchanged using JSON with keys:
 
-	task id
-	task type
-	data time
-	latitude
-	longitude 
-	postcode
-	city
-	objective
-	status
-	priority
-	getInstance
-	doInBackground
-	DeleteAllDataAsynceTask
-	ViewModel
-	Inset
-	Update
-	GetAllData
 

## Data Stored:
 Stores data in a single RoomsQL database table, with columns
-	task id
-	task type
-	data time
-	latitude
-	longitude 
-	postcode
-	
## Mobile specification:
-	get GPS location
-	notifications
-	screen rotation

## Testing:
- Q: Does the app work on multiple devices?  A: Yes
- Q: Does it work with no WIFI?   A: Yes
- Q: Does the app save all user inputs?   A: Yes
- Q: All buttons work and get recorded separately? A: Yes
- Q: App works with no GPS signal? A: Yes
- Q: Can you add as many lists as the user wants? A: yes
- Q: Does all lists get stored A: yes
- Q: Can the user access all the lists? A: Yes 
- Q: Will it still work if user does not select or input anything? A: Yes
- Q: Is there substitution text in case user does not input anything? A: Yes 
- Q: Does users list get saved when the app is closed? A: Yes 
- Q: Does the app remember last user input? A: Yes




https://user-images.githubusercontent.com/114151300/205937895-7c401956-78a2-471c-9d9e-7ec11196ca6d.mp4


