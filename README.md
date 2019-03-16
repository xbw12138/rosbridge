# rosbridge
[![](https://jitpack.io/v/xbw12138/rosbridge.svg)](https://jitpack.io/#xbw12138/rosbridge)

## Introductions
com.jiik.ros gradle版
## How to
* [x] Gradle

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency

```
	dependencies {
	        implementation 'com.github.xbw12138:rosbridge:1.0'
	}

```

-------
## Usage
Step 1. connect socket
```
        
        ROSBridgeClient client = new ROSBridgeClient("ws://" + ip + ":" + port);
        client.connect(new ROSClient.ConnectionStatusListener() {
            @Override
            public void onConnect() {
                client.setDebug(true);
                ((RCApplication)getApplication()).setRosClient(client);
                onLoginSuccess();
                progressDialog.dismiss();
            }
            @Override
            public void onDisconnect(boolean normal, String reason, int code) {
                onLoginFailed("ROS disconnect");
                progressDialog.dismiss();
            }

            @Override
            public void onError(Exception ex) {
                ex.printStackTrace();
                onLoginFailed("ROS communication error");
                progressDialog.dismiss();
            }
        });
```

-------

Step 2.  Send json to Ros by socket

```
    private void Move(float angle,float strength){
        String MegRight = "{\"op\":\"publish\",\"topic\":\""+ cmd +"\",\"msg\":{\"linear\":{\"x\":" + strength + ",\"y\": 0,\"z\":0},\"angular\":{\"x\":0,\"y\":0,\"z\":" + angle + "}}}";
        client.send(MegRight);
    }
```