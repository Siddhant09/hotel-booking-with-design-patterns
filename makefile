JAVA = java
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
controller/ClientController.java\
controller/ServerController.java\
controller/FrontController.java\
model/AbstractFactory.java\
model/Admin.java\
model/AdminFactory.java\
model/AuthorizationException.java\
model/Booking.java\
model/Command.java\
model/ConcerteModifyBooking.java\
model/ConcreteAddRoom.java\
model/ConcreteAddUser.java\
model/ConcreteAdmin.java\
model/ConcreteBrowseRooms.java\
model/ConcreteCancelBooking.java\
model/ConcreteDeleteRoom.java\
model/ConcreteDeleteUser.java\
model/ConcreteGuest.java\
model/ConcreteGuestBrowseRooms.java\
model/ConcreteReserveRoom.java\
model/ConcreteViewUser.java\
model/Database.java\
model/Dispatcher.java\
model/Entry.java\
model/FactoryProducer.java\
model/Guest.java\
model/GuestFactory.java\
model/HotelBooking.java\
model/HotelBookingImpl.java\
model/Invoker.java\
model/RequiresRole.java\
model/Role.java\
model/Room.java\
model/Room.java\
model/Session.java\
model/User.java\
view/AdminMenuView.java\
view/CurrentSessionView.java\
view/ErrorView.java\
view/GuestMenuView.java\
view/HomeView.java\

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) */*.class

serverController:
	$(JAVA) controller.ServerController

clientController:
	$(JAVA) controller.ClientController