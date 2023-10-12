float fwd = (R + L)/2
theta = IMU
relX = fwd
relY = strafe
x = relX * cos(theta) - relY * sin(theta)
y = relY * cos(theta) + relX * sin(theta)