require 'socket'

port = if ARGV[0] then ARGV[0] else 'echo' end
gate = TCPServer.open(port)

sock = gate.accept
gate.close

while msg = sock.gets
	sock.write("you say: " + msg)
	print("i get:", msg)
end
sock.close
