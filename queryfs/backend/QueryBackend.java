package queryfs.backend;

import java.util.Set;

import fuse.FuseException;

import queryfs.QueryGroup;

public interface QueryBackend {
	public Set<Node> query(Set<QueryGroup> groups);
	public Set<QueryGroup> subclass(Set<QueryGroup> groups);
	public void create(Set<QueryGroup> groups, String name) throws FuseException;
}
