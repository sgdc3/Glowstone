package net.glowstone.net.message.play.entity;

import com.flowpowered.network.Message;
import java.util.UUID;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.glowstone.util.Position;
import org.bukkit.Location;

@Data
@RequiredArgsConstructor
public final class SpawnObjectMessage implements Message {

    public static final int BOAT = 1;
    public static final int ITEM = 2;
    public static final int ENDER_CRYSTAL = 51;
    public static final int ITEM_FRAME = 71;
    public static final int FIREWORK = 76;
    public static final int LEASH_HITCH = 77;

    private final int id;
    private final UUID uuid; //TODO: Handle UUID
    private final int type;
    private final double x, y, z;
    private final int pitch, yaw, data, velX, velY, velZ;

    public SpawnObjectMessage(int id, UUID uuid, int type, double x, double y, double z, int pitch,
        int yaw) {
        this(id, uuid, type, x, y, z, pitch, yaw, 0, 0, 0, 0);
    }

    public SpawnObjectMessage(int id, UUID uuid, int type, double x, double y, double z, int pitch,
        int yaw, int data) {
        this(id, uuid, type, x, y, z, pitch, yaw, data, 0, 0, 0);
    }

    /**
     * Create an instance based on a location.
     *
     * @param id the entity id
     * @param uuid the entity UUID
     * @param type the network ID of the entity type
     * @param location The location whose x, y, z, pitch and yaw will be used
     */
    public SpawnObjectMessage(int id, UUID uuid, int type, Location location) {
        this(id, uuid, type, location, 0);
    }

    /**
     * Create an instance based on a location.
     *
     * @param id the entity id
     * @param uuid the entity UUID
     * @param type the network ID of the entity type
     * @param location the location whose x, y, z, pitch and yaw will be used
     * @param data as defined by the entity type
     */
    public SpawnObjectMessage(int id, UUID uuid, int type, Location location, int data) {
        this(id, uuid, type, location.getX(), location.getY(), location.getZ(),
                Position.getIntPitch(location), Position.getIntYaw(location), data);
    }

    public boolean hasFireball() {
        return data != 0;
    }

}
