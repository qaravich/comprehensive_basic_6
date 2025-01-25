# Circle class
class Circle:
    def __init__(self, radius):
        self.radius = radius
    
    def getArea(self):
        # Formula for area of circle: π * r^2
        return 3.14 * self.radius ** 2

# Cylinder class that inherits from Circle
class Cylinder(Circle):
    def __init__(self, radius, height):
        # Initialize the base class (Circle) with radius
        super().__init__(radius)
        self.height = height
    
    def getArea(self):
        # Override getArea to calculate the surface area of a cylinder
        # Formula for surface area of cylinder: 2πr(r + h)
        return 2 * 3.14 * self.radius * (self.radius + self.height)
    
    def getVolume(self):
        # Formula for volume of cylinder: π * r^2 * h
        return 3.14 * self.radius ** 2 * self.height

# Create an object of Cylinder class
cylinder = Cylinder(5, 10)

# Call the overridden getArea() method and getVolume() method
print("Surface Area of Cylinder:", cylinder.getArea())
print("Volume of Cylinder:", cylinder.getVolume())