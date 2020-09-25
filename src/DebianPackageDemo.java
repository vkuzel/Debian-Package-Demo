import java.io.IOException;
import com.sun.security.auth.module.UnixSystem;

public class DebianPackageDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Application started.");

		// Sleep for a while and then upgrade application.
		Thread.sleep(30_000);

		System.out.println("Schedule upgrade to new version.");
		String[] command = new String[] {"/bin/sh", "-c", "systemd-run --user --on-active=1 /usr/lib/debian-package-demo/debian-package-demo-upgrade.sh"};
		// Environment variable XDG_RUNTIME_DIR has to be set for
		// systemd-run to run correctly. Otherwise "Failed to create
		// bus connection" error will occur.
		String xdgRuntimeDir = "XDG_RUNTIME_DIR=/run/user/" + new UnixSystem().getUid();
		String[] environment = new String[] {};
		Runtime.getRuntime().exec(command, environment);

		// Let application run for eternity. It will be eventually
		// stopped when systemd service stops.
		Thread.sleep(1_000_000_000);

		System.out.println("Application exit.");
	}
}

